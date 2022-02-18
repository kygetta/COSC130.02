#include <stdio.h>
#include <stdlib.h>
//Brittany Miranda and Kylie Hall
//Code created:10/13/21
//Code Description: This code will read in a file of integers, calculate the average and print.
int main(){
FILE *file;

int num=0;
float counter=0;
float average=0;
float sum=0;

printf("Enter numbers...");

file = fopen("avgFile.txt","r");//opens the file

//while this file is open/true
while(1){
fscanf(file,"%d", & num);//access the elements in the file

//if the file is empty then it will tell the user that no numbers were read in.
if(file == NULL){
printf("No numbers were read");
}

printf("%d\n",num);//prints elements in the file

if(feof(file))//if it's the end of the file...
break;

counter++;//keeps track of how many elements are in the file.

sum+=num;//adds together elements
}


fclose(file);

average = sum/counter;//calculates average
printf("%f",average);//prints average
return 0;

}
