pushd "`dirname $(readlink -f $0)`"

java -cp "../libs/antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool -o src/generatedparser -package generatedparser ParsetoolsLexer.g4

java -cp "../libs/antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool -o src/generatedparser -package generatedparser ParsetoolsParser.g4

popd
