package org.example.reflection;

import org.example.reflection.model.Repository;
import org.example.reflection.model.RepositoryImpl;
import org.example.reflection.model.Service;
import org.example.reflection.model.ServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class ReflectionTest {

    @Test
    @DisplayName("Usage of Class")
    void test() {

        Class<Service> serviceClass = Service.class;
        Class<ServiceImpl> serviceImplClass = ServiceImpl.class;
        Class<Repository> repositoryClass = Repository.class;
        Class<RepositoryImpl> repositoryImplClass = RepositoryImpl.class;

        // 클래스의 이름을 얻기
        assertThat(serviceClass.getName()).isEqualTo("org.example.reflection.model.Service");
        assertThat(serviceImplClass.getName()).isEqualTo("org.example.reflection.model.ServiceImpl");
        assertThat(repositoryClass.getName()).isEqualTo("org.example.reflection.model.Repository");


        // =========================================================================================================
        /**
         * 접근 제어자
         */
        /**
         * Returns the Java language modifiers for this class or interface, encoded in an integer.
         * The modifiers consist of the Java Virtual Machine's constants for public, protected, private, final, static, abstract and interface;
         * they should be decoded using the methods of class Modifier.
         */
        int intServiceModifier = serviceClass.getModifiers();
        int intServiceImplModifier = serviceImplClass.getModifiers();
        int intRepositoryModifier = repositoryClass.getModifiers();

        // isAbstract, isFinal, isInterface, isPrivate, isProtected
        // isStatic, isStrict, isSynchronized, isVolatile
        String stringServiceModifier = Modifier.toString(intServiceModifier);
        String stringServiceImplModifier = Modifier.toString(intServiceImplModifier);
        String stringRepositoryModifier = Modifier.toString(intRepositoryModifier);

        assertThat(stringServiceModifier).isEqualTo("public abstract");
        assertThat(stringServiceImplModifier).isEqualTo("public");
        assertThat(stringRepositoryModifier).isEqualTo("public abstract interface");


        assertThat(Modifier.isAbstract(intServiceModifier)).isTrue();
        assertThat(Modifier.isFinal(intServiceModifier)).isFalse();
        assertThat(Modifier.isAbstract(intRepositoryModifier)).isTrue(); // isAbstract까지 통과할정도면 인터페이스는 abstract가 맞다. https://stackoverflow.com/a/16579929 As show here, interface is completely abstract

        // =========================================================================================================

        // getInterfaces는
        Class<?>[] serviceClassInterfaces = serviceClass.getInterfaces();
        Class<?>[] repositoryImplClassInterfaces = repositoryImplClass.getInterfaces();
        Class<?>[] repositoryClassInterfaces = repositoryClass.getInterfaces();


        boolean isRepositoryHasInterfaces = Arrays.stream(repositoryClassInterfaces).anyMatch(aClass -> aClass.getName().equals("org.example.reflection.Repository"));

        // Repository는 interface 그 자체이므로 getInterfaces해도 암것두 없음
        assertThat(isRepositoryHasInterfaces).isFalse();

        // 마찬가지로 Service는 abstract class 이므로 유관 interface 없음
        assertThat(serviceClassInterfaces.length).isEqualTo(0);

        boolean isRepositoryImplHasInterfaces = Arrays.stream(repositoryImplClassInterfaces).anyMatch(aClass -> aClass.getName().equals("org.example.reflection.Repository"));

        // 그러나 RepositoryImpl은 Repository란 interface를 구현(implement)하므로 getInterface의 값이 있음
        assertThat(isRepositoryImplHasInterfaces).isTrue();

        // RepositoryImpl의 superclass는 Repository가 아니다! 인터페이스라 그런듯
        assertThat(RepositoryImpl.class.getSuperclass().getName()).isNotEqualTo("org.example.reflection.Repository");
        assertThat(RepositoryImpl.class.getSuperclass().getName()).isEqualTo("java.lang.Object");

        // 그럼에도 불구하고, ServiceImpl의 superclass는 Service가 맞다.
        assertThat(ServiceImpl.class.getSuperclass().getName()).isEqualTo("org.example.reflection.Service");
    }

    @Test
    @DisplayName("Usage of Method")
    void testMethod() {
        Class<?> serviceImplClass = ServiceImpl.class;

        Method[] declaredMethods = serviceImplClass.getDeclaredMethods();

        Collection<String> collectDeclaredMethodNames = Arrays.stream(declaredMethods).map(method -> method.getName()).collect(Collectors.toList());

        assertThat(collectDeclaredMethodNames).contains("getOtherPrivate").contains("getPrivate").contains("setIdCode").contains("setHeight").contains("getIdCode").contains("getHeight");


        for (Method eachMethod : declaredMethods) {

            System.out.println("\n");

            System.out.println("eachMethod.getName() = " + eachMethod.getName());
            System.out.println("eachMethod.getReturnType() = " + eachMethod.getReturnType());
            System.out.println("eachMethod.getParameterTypes() = ");
            Class<?>[] parameterTypes = eachMethod.getParameterTypes();
            for (Class<?> each : parameterTypes) {
                System.out.println(each.getName());
            }

            System.out.println("\n");
        }
    }

    @Test
    @DisplayName("생성자에 대해 알아봄")
    void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<ServiceImpl> serviceClass = ServiceImpl.class;

        // 생성자를 찾을땐 Parameter를 기준으로 찾는다.
//        Constructor<ServiceImpl> constructor = serviceClass.getConstructor(new Class[]{Repository.class});
        //위 아래 같음.
        Constructor<ServiceImpl> constructor = serviceClass.getConstructor(Repository.class);

        // 생성자를 얻었음.
        // 생성자를 얻었으니, 써봐야함
        ServiceImpl service = constructor.newInstance(new RepositoryImpl());

    }

    @Test
    @DisplayName("필드에 대해 알아봄")
    void testField() throws NoSuchFieldException, IllegalAccessException {
        Class<Service> serviceClass = Service.class;

        // 필드들 둘러보기
        Field[] declaredFields = Service.class.getDeclaredFields();

        for (Field eachField : declaredFields) {
            assertThat(eachField.getName()).isEqualTo("repository"); // -> getName은 필드의 타입명이 아닌 필드명을 가져온다.

        }

        // 필드 찝어서 가져오기
        Field repository = Service.class.getDeclaredField("repository");

        assertThat(repository.getName()).isEqualTo("repository");


        // 실제 인스턴스 만들어서, 클래스의 리플렉트에다가 파라미터로 인스턴스 넘겨서 실제 값 가져오기
        System.out.println("============================");
        System.out.println("여기 Default Constructor 호출");
        Service newServiceInstance = new ServiceImpl();
        System.out.println("============================");

        /**
         * 원래 플로우랑 다르다.
         *
         * 원래 플로우는 인스턴스.getField인데
         *
         * 이 리플렉션을 이용하면 Field.getInstance(targetInstance)이다.
         */
        try{
            Repository o = (Repository) repository.get(newServiceInstance);
        }catch (IllegalAccessException e){
            // 여기서 IllegalAccessException: class org.example.reflection.TestEntry cannot access a member of class org.example.reflection.Service with modifiers "private"
            // 즉 private 필드에 접근 못하는 에러가 난다. 따라서 다음과 같이 access Modifier 즉, 접근 제어자를 풀어줘야한다.
        }

        // 이거 필드임
        repository.setAccessible(true); // 억세스 해제

        Object o = repository.get(newServiceInstance);

        assertThat(o).isInstanceOf(Repository.class);
    }

    /**
     * accessible 여부에 따라 다르다.
     */
    @Test
    @DisplayName("getDeclaredXXX와 getXXX의 차이")
    void testGetDeclared(){

        Class<ServiceImpl> serviceClass = ServiceImpl.class;

        Field[] declaredFields = serviceClass.getDeclaredFields();

        System.out.println("\n=DeclaredField=\n");
        for (Field eachDeclaredField : declaredFields) {
            System.out.println(eachDeclaredField.getName());
        }

        /**
         * ServiceImpl에는 repository 필드가 없다. 객체지향과는 좀 다른느낌인데,
         * 상속받았으니 피상속 인스턴스는 repository 데이터를 갖고 있는것은 맞으나,
         * 피상속 클래스는 repository 필드를 flat하겐 갖고 있지 않은 상황이다.
         */
        boolean isRepositoryFieldExist = Arrays.stream(declaredFields).anyMatch(field -> field.getName().equals("repository"));

        assertThat(isRepositoryFieldExist).isFalse();

        /**
         * getField의 docs를 보면 accessible한 field에만 접근한다고 나와있다.
         */
        Field[] fields = serviceClass.getFields();

        System.out.println("\n=Field=\n");
        for (Field eachField : fields) {
            System.out.println(eachField.getName());
        }

        // getMethod와 getDeclaredMethod가 차이가 있다. 아무래도 getDeclaredMethod는 private까지 다 불러오나?
        // 그렇다, 그리고 상속받은 메서드들은 안보여준다. object에게 상속받은 wait 같은 메서드가 없다.
    }

    @Test
    @DisplayName("method invoke 해보기")
    void testMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ServiceImpl service = new ServiceImpl();

        Method method = ServiceImpl.class.getDeclaredMethod("getPrivate");
        method.setAccessible(true);

        System.out.println("\n==Before Invoke==\n");
        Object invoked = method.invoke(service);
        System.out.println("\n==After Invoke==\n");

        Class<?> returnType = method.getReturnType();

        System.out.println(invoked);
        System.out.println(returnType);
    }

    @Test
    @DisplayName("method parameter 랑 같이 invoke 해보기")
    void callMethodWithParameters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?>[] parameters = {Integer.TYPE, String.class}; // primitive를 선언하는법

        /**
         * 파라미터있는 메서드는 파라미터 없이는 못찾네...
         */
        Method method = ServiceImpl.class.getDeclaredMethod("getOtherPrivate", parameters);

        method.setAccessible(true);

        // 인스턴스 생성
        Service service = new ServiceImpl();

        Object invoke = method.invoke(service,7,"hey");

        assertThat(invoke).isEqualTo("How did you get here" + 7 + " " + "hey");
    }


}
