package ch.vingolds.testopenrewrite;

public class WithEmptyBlock {

  public static class Base {
    public boolean isExtended() {
      return false;
    }
  }

  public static class Extender extends Base {

    @Override
    public boolean isExtended() {
      return true;
    }

    public boolean isExtendedClass() {
      return true;
    }

    public boolean isSomeOtherClass() {
      return false;
    }
  }

  public void shouldNotFlipCondition(Base arg) {

    if (arg.isExtended()) {
      if (((Extender) arg).isExtendedClass()
          || ((Extender) arg).isSomeOtherClass()) {
      } else {
        System.out.println("This line should not be executed!");
        throw new RuntimeException("code should not reach here! if you see this, rewrite has messed up.");
      }
    }
  }
}
