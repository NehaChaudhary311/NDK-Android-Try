#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_meetdemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_meetdemo_MainActivity_stringForMakeDiscoverable(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "You're out for discovery now";
    return env->NewStringUTF(hello.c_str());
}
