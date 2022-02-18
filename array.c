#include <stdio.h>
#include <math.h>
//Created by: Brittany Miranda, Kylie Hall
//Date: 10/15/21

//Code Description: Write a program that allows the user to enter 10 numbers. 
//Store these numbers in an array. Then compute their mean (average) and standard deviation. 
//The standard deviation is the square root of the variance of the numbers. 
//The variance is the mean of the squares of the difference between the number and its mean.

float StandardDev(float ar[]);
//Method description: It will ask user for 10 numbers to store into an array. This method also calls for the Standard
//Dev method that will evaluate and print the mean and Standard Deviation of the 10 numbers given.
int main(){

float ar[10];//initialize array length 10
int i;//used in for loop

//ask user for 10 numbers and store in array 
for(i=0;i<10;i++){
printf("Enter a number\n");
scanf("%f", &ar[i]);//stores into float ar[]
}
printf("Standard Deviation: %f", StandardDev(ar));//calls for Standard dev method and prints the return value SD.

return 0;
}

//Method description: Here we are calculating the mean and standard deviation of the elements in ar[]
float StandardDev(float ar[]){
int i;
float sum =0.0;
float SD = 0.0;
float mean = 0.0;

//for loop below will add all 10 float nums together
for(i=0;i<10;i++){
sum = sum + ar[i];
}
//CAlculate mean and print
mean = sum/10;
printf("Mean: %f", mean);

//for loop below will find the Standard deviation
for(i=0;i<10;i++){
SD += pow(ar[i] - mean, 2);
}
SD = sqrt(SD/10);

//returns standard deviation to print in main method.
return SD;

}
