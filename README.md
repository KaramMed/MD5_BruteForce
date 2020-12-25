# MD5_BruteForce
Brute Force Attack using Java against MD5

- Search_Thread : this class has the main thread to start searching the password , it receives an interval
of search characters for the first symbole and use them for search


- Server1 , Server2 : these classes while receiving the number N , they divide the intervals of search for 
the first character and run N threads each one with an interval of search , once of them finds out the password
it stops all other threads


- Main_Server : this is the main class , ( the one you should run ) , it receives the hashcode , and the number N
from the user input , then start both servers

---------------------
*Advice for testing :
better use N=4 threads [ optimal time ]
and use these hashcodes for testing before using assignements hashcode ( just to make sure everything alright ) :
* bf6871d4fdbe9c0955bf304eaa06c640
* 821f40e6beabbc20876d3e0e9ed2bef7
* 6766f4262b2c600eddcf5461c7e9938a
