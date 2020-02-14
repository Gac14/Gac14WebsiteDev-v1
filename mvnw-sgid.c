#include <unistd.h>

int main(int argc,char** argv,char** envp){
    return execve("./gradlew",argv,envp);
}

