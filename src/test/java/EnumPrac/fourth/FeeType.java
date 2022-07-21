package EnumPrac.fourth;

/**
 * Enum 은 미리 선언한 인터페이스를 구현(implements)만 하면 됩니다.
 */
public enum FeeType implements EnumMapperType{
    PERCENT("정율"),
    MONEY("정액");

    private String title;

    FeeType(String title) {
        this.title = title;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
