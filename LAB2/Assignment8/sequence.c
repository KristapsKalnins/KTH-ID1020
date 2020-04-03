#include <stdlib.h>
#include <stdio.h>

// Usage: generateInput seed nrIntegers maxInt
// Output: nrIntegers in interval [0,maxInt]

int main(int argc, char *argv[])
{
unsigned int seed;
unsigned long nrIntegers = 0;
long maxInt = 0;
unsigned long i = 0;
unsigned long cut = 0;

sscanf(argv[1],"%d", &seed);
sscanf(argv[2],"%d", &nrIntegers);
sscanf(argv[3],"%d", &maxInt);
sscanf(argv[4],"%d", &cut);

printf("%d\n", cut);
printf("%d\n", nrIntegers);

srandom(seed);
while(i++ < nrIntegers)
printf("%d\n", (long)(maxInt * ((double)random()/(double)RAND_MAX)));
}