#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <winSock2.h>

#pragma warning(disable : 4996)
#pragma comment(lib, "ws2_32.lib")

// User and Launcher Information
#define NICKNAME "SEOUL01_LEESSAFY"
#define HOST "127.0.0.1"

// Static Value(Do not modify)
#define PORT 1447

void ErrorHandling(char *message);

int main()
{
	// Predefined Variables(Do not modify)
	int TABLE_WIDTH = 254;
	int TABLE_HEIGHT = 127;
	int NUMBER_OF_BALLS = 6;
	int HOLES[6][2] = {{0, 0}, {127, 0}, {254, 0}, {0, 127}, {127, 127}, {254, 127}};

	WSADATA wsaData;
	SOCKET hSocket;
	SOCKADDR_IN sockAddr;

	if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0)
		ErrorHandling("WSAStartup failure.");

	hSocket = socket(PF_INET, SOCK_STREAM, 0);

	if (hSocket == INVALID_SOCKET)
		ErrorHandling("Socket Creating Failure.");

	memset(&sockAddr, 0, sizeof(sockAddr));
	sockAddr.sin_family = AF_INET;
	sockAddr.sin_addr.s_addr = inet_addr(HOST);
	sockAddr.sin_port = htons(PORT);

	printf("Trying Connect: %s:%d\n", HOST, PORT);
	if (connect(hSocket, (SOCKADDR *)&sockAddr, sizeof(sockAddr)) == SOCKET_ERROR)
		ErrorHandling("Connection Failure.");
	else
		printf("Connected: %s:%d\n", HOST, PORT);

	char sendData[50];

	sprintf(sendData, "9901/%s/", NICKNAME);
	send(hSocket, (char *)&sendData, sizeof(sendData), 0);
	printf("Ready to play!\n--------------------");

	closesocket(hSocket);
	WSACleanup();

	return 0;
}

void ErrorHandling(char *message)
{
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
}