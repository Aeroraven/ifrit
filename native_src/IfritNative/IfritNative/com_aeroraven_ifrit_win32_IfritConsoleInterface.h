/* DO NOT EDIT THIS FILE - it is machine generated */
#include "jni.h"
/* Header for class com_aeroraven_ifrit_win32_IfritConsoleInterface */

#ifndef _Included_com_aeroraven_ifrit_win32_IfritConsoleInterface
#define _Included_com_aeroraven_ifrit_win32_IfritConsoleInterface
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_aeroraven_ifrit_win32_IfritConsoleInterface
 * Method:    ICI_GetStdHandle
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1GetStdHandle
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_aeroraven_ifrit_win32_IfritConsoleInterface
 * Method:    ICI_SetConsoleTextAttribute
 * Signature: (JS)Z
 */
JNIEXPORT jboolean JNICALL Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1SetConsoleTextAttribute
  (JNIEnv *, jclass, jlong, jshort);

/*
 * Class:     com_aeroraven_ifrit_win32_IfritConsoleInterface
 * Method:    ICI_SetConsoleCursorPosition
 * Signature: (JSS)Z
 */
JNIEXPORT jboolean JNICALL Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1SetConsoleCursorPosition
  (JNIEnv *, jclass, jlong, jshort, jshort);

/*
 * Class:     com_aeroraven_ifrit_win32_IfritConsoleInterface
 * Method:    ICI_GetConsoleCursorPositionX
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1GetConsoleCursorPositionX
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_aeroraven_ifrit_win32_IfritConsoleInterface
 * Method:    ICI_GetConsoleCursorPositionY
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1GetConsoleCursorPositionY
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_aeroraven_ifrit_win32_IfritConsoleInterface
 * Method:    ICI_SetConsoleFontInfoEx
 * Signature: (ISSIILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_aeroraven_ifrit_win32_IfritConsoleInterface_ICI_1SetConsoleFontInfoEx
  (JNIEnv *, jclass, jint, jshort, jshort, jint, jint, jstring);

#ifdef __cplusplus
}
#endif
#endif
