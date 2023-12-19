all:
	javac src/*.java   

run:
	java src/Main

clean:
	rm -vf src/*.class