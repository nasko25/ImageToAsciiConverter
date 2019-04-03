#! /bin/bash

FILE="ImageToAscii.class"
if [ -e ./"$FILE" ]; then
	rm $FILE
else 
	printf "Program is not compiled.\n...Compiling...\n\n"
fi

javac ImageToAscii.java
printf "OUTPUT:\n"
java ImageToAscii $1 $2

