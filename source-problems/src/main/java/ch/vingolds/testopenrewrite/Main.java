package ch.vingolds.testopenrewrite;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
    System.out.println("Hello and welcome!");

    new WithEmptyBlock().shouldNotFlipCondition(new WithEmptyBlock.Extender());
  }
}
