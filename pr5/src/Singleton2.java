public class Singleton2 {
    private Singleton2() {}

    private static class SingletonHolder {
        private static Singleton2 singleton2 = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.singleton2;
    }
}
