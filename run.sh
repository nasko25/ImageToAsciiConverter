#! /bin/bash

FILE="ImageToAscii.class"
if [ -e ./"$FILE" ]; then
	rm $FILE
else 
	echo "File does not exists"
fi

javac ImageToAscii.java
printf "OUTPUT:\n"
java ImageToAscii $1

