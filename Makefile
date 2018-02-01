#MakeFile to build simple TCP client server program
# For CSC Computer Networking

CC= g++

# These flags only needed on SUNOS
FLAGS =  -lnsl

all:	TCPagent

TCPagent.o: TCPagent.cpp	
		$(CC) -c TCPagent.cpp

TCPagent: TCPagent.o
		$(CC) TCPagent.o -o TCPagent $(FLAGS)

clean:
		rm -f *.o TCPagent
