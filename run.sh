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

# https://www.lifewire.com/pass-arguments-to-bash-script-2200571
