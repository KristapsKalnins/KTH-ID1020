/*****************************************************************
 *          TCOMK2  Kristaps Kalniņs
 *      Searches for words in a text files and prints at which char
 * the word can be found.
 *         
 * 
 * 
 * **************************************************************/
#include <stdio.h>
#include <ctype.h>


void finder(char* array, int lengthOfWord){
    int mainCount = -4;
    int foundCount = 0;
    int subCount[8000];
    int test = 0;
    int arrayCount = 0;

    char lastc;
    char c=getchar();
    mainCount++;
    while((lastc = c) != EOF){
        c = getchar();
        if(c == '\n')
            mainCount += 2;
        else
            mainCount++;
        if((!isalpha(lastc) || lastc == ' ' )&& c == array[0]){
            test = mainCount;
            for(int i = 1; i <= lengthOfWord; i++){
                lastc = c;
                c = getchar();
                if(c == '\n')
                    mainCount += 2;
                else
                    mainCount++;
                if(c != array[i]){ break;}
            }
            if((!isalpha(c) || c == ' ')&& lastc == array[lengthOfWord-1]){
                foundCount++;
                subCount[arrayCount++] = test;
            }
        }
    }
    printf("%d\n", mainCount);
    printf("%d\n", foundCount);
    for(int i = 0; i < foundCount; i++){
        printf("Word found at %d\n", subCount[i]);
    }

}

int main(){
    char array[6] = {"laying"};

    finder(array, 6);


}