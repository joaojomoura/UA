#include <stdio.h>
#include <math.h>

int main (int argc, char* argv[]) {

	int i;

	for (i = 0; i <= 360; i = i+30)
		printf("%3d | %f | %f | %f\n", i, (double) sin (i * (M_PI/180.0)), (double) cos (i * (M_PI/180.0)), pow((double)sin (i),2) + pow((double)cos(i),2));

}