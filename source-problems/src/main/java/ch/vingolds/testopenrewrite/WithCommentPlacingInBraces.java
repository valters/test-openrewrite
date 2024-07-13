package ch.vingolds.testopenrewrite;

import java.io.File;

public class WithCommentPlacingInBraces {

  public void shouldKeepTrackOfComments(boolean success) {

    // keep track of comments corresponding to lines
    if (success)
      System.out.println("success comment belongs here: but somehow failure comment ends up here"); // success!
    else
      System.out.println("failure comment belongs here: but somehow comment at end of line gets moved before else?"); // failure! this should stay here, firmly inside `else` block
    // this line should stay in place. the comments at end of line, above, should not get mixed up! but somehow this gets moved into `if {}` block?
  }

  public int shouldKeepTrackOfBlockComment(File f) {

    if (f.length() > 0) {
      System.out.println("file is not empty");
    }
    /*
     * this comment should not be lost.
     * it would be great if it went inside the `else {}` block.
     */
    else
      System.out.println("where did the comment go?");
    return 0;
  }

  public int shouldKeepTrackOfComments(String s) {
    if ("ok".equals(s))
      return 1;
      // this comment should not be lost.
      // it would be great if it went inside the `if {}` block.
    else {
      System.out.println("where did the comment go?");
      // nothing
    }
    return 0;
  }
}
