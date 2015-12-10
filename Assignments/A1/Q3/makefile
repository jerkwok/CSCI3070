all: clean run

clean :
	rm -f *.class *.dat 

prepare : 
	javac generator.java
	java -cp ../ Q3.generator


run :
	javac sorter.java
	java -Xmx2G -cp ../ Q3.sorter
