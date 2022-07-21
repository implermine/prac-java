package EnumPrac.fourth;

/**
 * 값을 담을 클래스(VO)는 이 인터페이스를 생성자로 받아 인스턴스를 생성하도록 함.
 */
public class EnumMapperValue {

    private String code;
    private String title;

    // 인터페이스를 인자로 받음
    //this may look like 'Composition'
    public EnumMapperValue(EnumMapperType enumMapperType){
        this.code = enumMapperType.getCode();
        this.title = enumMapperType.getTitle();
    }

    public String getCode(){
        return code;
    }
    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return "EnumMapperValue{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
