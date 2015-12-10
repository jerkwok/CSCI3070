all: clean prepare run

clean :
	rm -f *.class runtime.txt merge.txt quick.txt heap.txt 

prepare : 
	javac *.java
	touch runtime.txt merge.txt quick.txt heap.txt 

n ?= 100
run :
	n=$(n); \
	while [ $${n} -gt 0 ] ; do \
		echo $$n ; \
		n=`expr $$n - 1`; \
		java -cp ../ Q2.handler; \
	done;
	python MyPlot.py
