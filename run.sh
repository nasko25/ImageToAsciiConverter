#! /bin/bash

FILE="ImageToAscii.class"
if [ -e ./"$FILE" ]; then
	rm $FILE
else 
	echo "File does not exists"
fi

javac -cp jmagick-6.4.0.jar ImageToAscii.java
printf "OUTPUT:\n"
java -cp ./:jmagick-6.4.0.jar ImageToAscii $1

# https://www.lifewire.com/pass-arguments-to-bash-script-2200571
