#include <unistd.h>

int main(int argc,char** argv,char** envp){
    return execve("./mvnw",argv,envp);
}

