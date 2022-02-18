(*Kylie Hall and Kara Peterson*)

fun cube x = x*x*x;
(*fun cube returns x^3 as an int*)

fun cuber x:real = x*x*x;
(*fun cuber returns x^3 for real numbers*)

fun min3 (x1:int,x2:int,x3:int) =
		       if x1<x2 andalso x1<x3
		       then x1
		       else if x2<x1 andalso x2<x3
		       then x2
		       else
			   x3;



(*fun min3 uses if statements to return the smallest of 3 integers entered*)

fun cycle1 L =
    tl L @ [hd L];
(*fun cycle1 will remove and add the first element of the list to the end First idea was to use tl but it wouldnt run properly.*)

fun sort3 (a1:real :: (a2:real :: (a3)))) =
    if a1<a2 andalso a2<a3 then
	[a1,a2,a3]
    else if a1<a2 andalso a2<a3 then
	[a1,a3,a2]
    else
	[x3];
(*fun sort3 will sort a list of real numbers in order smallest to biggest*)
						
fun del3 1::2::3::4 =
   hd[]
     tl[]
     hd[]
   [1,2]@[4];
(*fun del3 will take in a list and then delete the 3rd element*)

fun sqsum n=
    if n = 0 then 0
    else (n*n) + sqsum(n-1);
(*fun sqsum returns the sum of the squares of all ints 0-n*)
						    
fun ex11 (L,t) =
    if t = 0
    then L
    else cycle1(cycle(L,t-1));
(* fun ex11 OR EXERCISE 11 uses the cycle function to rotate the elements in the list k amount of times.*)

fun max []:int =
    if hd<tl
    then Lrg = tl else Lrg = hd 
	     max();
fun maxhelper largest:int =
    max();
fun max x = maxhelper (tl x, hd x);
(*The idea for the code above is to loop through a given loop and find the largest element so if you compare the head and tail of the list you can loop through using the maxhelper function.*)
		     

(*fun isPrime ex done in class*)
				   

			  
			      
