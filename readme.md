# OpenRewrite test project

This demonstrates some issues that are currently tripping up OpenRewrite (as of 2024-07-13), version 5.35.0 (and rewrite-static-analysis version 1.11.0).

## NeedBraces removes the `else` keyword, forgets to flip `if` condition if the `if` `{}` block as empty.

1. Build it
```shell
./mvnw clean package
```
2. Run it
```shell
./mvnw clean package exec:java --projects source-problems -Dexec.mainClass="ch.vingolds.testopenrewrite.Main"
```
3. Rewrite it
```shell
./mvnw --activate-profiles openrewrite org.openrewrite.maven:rewrite-maven-plugin:run
```
4. Run it again: does it fail?
```shell
./mvnw clean package exec:java --projects source-problems -Dexec.mainClass="ch.vingolds.testopenrewrite.Main"
```
You will see output like this:
```
Hello and welcome!
This line should not be executed!
[WARNING] 
java.lang.RuntimeException: code should not reach here! if you see this, rewrite has messed up.
    at ch.vingolds.testopenrewrite.WithEmptyBlock.shouldNotFlipCondition (WithEmptyBlock.java:33)
```
5. See the issue:
```shell
git diff source-problems/src/main/java/ch/vingolds/testopenrewrite/WithEmptyBlock.java
```
## NormalizeLineBreaks does not actually do anything

The `NormalizeLineBreaks` and `NormalizeTabsOrSpaces` don't normalize `\r\n\` Windows style
line breaks to `\n` Unix style line breaks at all.

## NeedBraces loses or misplaces comments

After rewrite, the comments in WithCommentPlacingInBraces are messed up in several ways.
Please examine diff:
```shell
git diff source-problems/src/main/java/ch/vingolds/testopenrewrite/WithCommentPlacingInBraces.java
```
