/*******************************************************************************

 Graphical program for simulate the ADT Digraph


 Autor : António Manuel Adrego da Rocha    Data : Maio de 2019

*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "digraph.h"  /* ADT Interface file */
#include "queue.h"  /* Queue Interface file */

#define MAX_DIGRAPHS 22
#define MAX_OPTIONS 18

void Menu (void);
void ReadOption (int *);
void ReadDigraphIndex (int *, char *);
int ActiveDigraph (PtDigraph *, int);
int NotActiveDigraph (PtDigraph *, int);
void ReadFilename (char *);
void WriteErrorMessage (unsigned int, char *);
void ReadVertex (unsigned int *);
void ReadEdge (unsigned int *, unsigned int *);
void ReadCostDist (int *, char *);
void ReadType (unsigned int *);
void WriteDigraph (PtDigraph);
void WritePath (unsigned int[], unsigned int);
void WriteAllPaths (unsigned int[], int[], unsigned int, unsigned int pnv);
void PrintQueue (PtQueue, char *);
void PrintQueuePair (PtQueue, char *);

int main (void)
{
  PtDigraph DigraphArray[MAX_DIGRAPHS];
  int Option, Index, Digraph1, Digraph2, Error, Cost, Dist;
  unsigned int NVertexes, NEdges, DigType, Vertex1, Vertex2;
  char Filename[21]; double Classification; PtQueue Queue = NULL;

  for (Index = 0; Index < MAX_DIGRAPHS; Index++) DigraphArray[Index] = NULL;
  
  do
  {
    /* cleaning the screen and presenting the menu */
    Menu ();

    /* presenting the active digraphs */
    for (Index = 0; Index < MAX_DIGRAPHS; Index++)
      if (DigraphArray[Index] != NULL)
      {
        Type (DigraphArray[Index], &DigType);
        VertexNumber (DigraphArray[Index], &NVertexes);
        EdgeNumber (DigraphArray[Index], &NEdges);
        if (DigType) printf ("\e[1m\e[%d;36fDigrafo", 5+Index); else printf ("\e[1m\e[%d;36f  Grafo", 5+Index);
        printf ("\e[1m\e[%d;49fV = %d / A = %d", 5+Index, NVertexes, NEdges);
        printf ("\e[0m");
      }

    /* reading the user option */
    ReadOption (&Option);

    switch (Option)
    {
        case 1 :  ReadDigraphIndex (&Digraph1, "digraph/graph");
                  if (ActiveDigraph (DigraphArray, Digraph1)) break;
                  ReadType (&DigType);
                  DigraphArray[Digraph1] = Create (DigType);
                  if (DigraphArray[Digraph1] == NULL) WriteErrorMessage (NO_MEM, "The creation");
                  break;

        case 2 :  ReadDigraphIndex (&Digraph1, "digraph/graph");
                  if (ActiveDigraph (DigraphArray, Digraph1)) break;
                  ReadFilename (Filename);
                  DigraphArray[Digraph1] = CreateFile (Filename);
                  if (DigraphArray[Digraph1] == NULL) WriteErrorMessage (NO_MEM, "The reading");
                  break;

        case 3 :  ReadDigraphIndex (&Digraph1, "digraph/graph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
		          ReadVertex (&Vertex1);
                  Error = InVertex (DigraphArray[Digraph1], Vertex1);
                  if (Error) WriteErrorMessage (Error, "The vertex insertion");
                  break;

        case 4 :  ReadDigraphIndex (&Digraph1, "digraph/graph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
		          ReadVertex (&Vertex1);
                  Error = OutVertex (DigraphArray[Digraph1], Vertex1);
                  if (Error) WriteErrorMessage (Error, "The vertex deletion");
                  break;

        case 5 :  ReadDigraphIndex (&Digraph1, "digraph/graph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
		          ReadEdge (&Vertex1, &Vertex2);
		          ReadCostDist (&Cost, "Edge cost");
                  Error = InEdge (DigraphArray[Digraph1], Vertex1, Vertex2, Cost);
                  if (Error) WriteErrorMessage (Error, "The edge insertion");
                  break;

        case 6 :  ReadDigraphIndex (&Digraph1, "digraph/graph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
		          ReadEdge (&Vertex1, &Vertex2);
                  Error = OutEdge (DigraphArray[Digraph1], Vertex1, Vertex2);
                  if (Error) WriteErrorMessage (Error, "The edge deletion");
                  break;

        case 7 :  ReadDigraphIndex (&Digraph1, "digraph/graph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  ReadFilename (Filename);
                  Error = StoreFile (DigraphArray[Digraph1], Filename);
                  if (Error) WriteErrorMessage (Error, "The storing");
                  break;

        case 8 :  ReadDigraphIndex (&Digraph1, "origin digraph/graph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  do
                  {
                     ReadDigraphIndex (&Digraph2, "destination digraph/graph"); 
                  } while (Digraph2 == Digraph1);
                  if (ActiveDigraph (DigraphArray, Digraph2)) break;
                  DigraphArray[Digraph2] = Copy (DigraphArray[Digraph1]);
                  if (DigraphArray[Digraph2] == NULL) WriteErrorMessage (NO_MEM, "The copy");
                  break;
		  
        case 9 :  ReadDigraphIndex (&Digraph1, "digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  WriteDigraph (DigraphArray[Digraph1]);
                  printf("\e[1m\e[34;1f| Digraph %d                     ", Digraph1);
                  printf("\e[0m\e[35;1f| Press a key to continue ");
                  scanf ("%*[^\n]"); scanf ("%*c");
                  break;

        case 10 : ReadDigraphIndex (&Digraph1, "digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  Error = Destroy (&DigraphArray[Digraph1]);
                  if (Error) WriteErrorMessage (Error, "The elimination");
                  break;

        case 11 : ReadDigraphIndex (&Digraph1, "digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
		          ReadVertex (&Vertex1);
                  Error = VertexType (DigraphArray[Digraph1], Vertex1);
                  switch (Error)
		          {
                     case OK     : printf("\e[1m\e[34;3f3fNormal vertex ");  break;
                     case SINK   : printf("\e[1m\e[34;3fSink vertex");  break;
		             case SOURCE : printf("\e[1m\e[34;3fSource vertex");  break;
		             case DISC   : printf("\e[1m\e[34;3fDisconnected vertex");  break;
		             default     : WriteErrorMessage (Error, "The vertex test");
                  }
	              printf("\e[0m\e[35;1f| Press a key to continue ");
                  scanf ("%*[^\n]"); scanf ("%*c");
                  break;

        case 12 : ReadDigraphIndex (&Digraph1, "digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  ReadVertex (&Vertex1); 
		          Error = VertexClassification (DigraphArray[Digraph1], Vertex1, &Classification);
                  if (Error) { WriteErrorMessage (Error, "The classification of vertexes"); break; }
		          printf("\e[1m\e[34;1f| Classification of vertex %d = %f ", Vertex1, Classification);
                  printf("\e[0m\e[35;1f| Press a key to continue ");
                  scanf ("%*[^\n]"); scanf ("%*c");
                  break;
			
        case 13 : ReadDigraphIndex (&Digraph1, "digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  ReadEdge (&Vertex1, &Vertex2);
		          Error = DigraphEdgeSplit (DigraphArray[Digraph1], Vertex1, Vertex2);
                  if (Error) { WriteErrorMessage (Error, "The edge splitting"); break; }
                  break;

        case 14 : ReadDigraphIndex (&Digraph1, "digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  ReadVertex (&Vertex1); 
		          Error = DigraphVertexSplit (DigraphArray[Digraph1], Vertex1);
                  if (Error) { WriteErrorMessage (Error, "The vertex splitting"); break; }
                  break;

        case 15:  ReadDigraphIndex (&Digraph1, "origin digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  do
                  {
                     ReadDigraphIndex (&Digraph2, "destination digraph"); 
                  } while (Digraph2 == Digraph1);
                  if (ActiveDigraph (DigraphArray, Digraph2)) break;
                  DigraphArray[Digraph2] = DigraphTranspose (DigraphArray[Digraph1]);
                  if (DigraphArray[Digraph2] == NULL) WriteErrorMessage (NO_MEM, "The transpose digraph");
                  break;
	  
        case 16 : ReadDigraphIndex (&Digraph1, "origin digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  do
                  {
                     ReadDigraphIndex (&Digraph2, "destination digraph"); 
                  } while (Digraph2 == Digraph1);
                  if (ActiveDigraph (DigraphArray, Digraph2)) break;
                  DigraphArray[Digraph2] = DigraphComplement (DigraphArray[Digraph1]);
                  if (DigraphArray[Digraph2] == NULL) WriteErrorMessage (NO_MEM, "The complement digraph");
                  break;

        case 17:  ReadDigraphIndex (&Digraph1, "digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  ReadVertex (&Vertex1);
                  ReadCostDist (&Dist, "Distance ");
                  Error = AllSuccDist (DigraphArray[Digraph1], Vertex1, Dist, &Queue);
                  if (Error) { WriteErrorMessage (Error, "The successors vertexes"); break; }
                  if (QueueIsEmpty (Queue)) printf("\e[1m\e[34;1f| Ther are no successors vertexes of vertex %d at a distance less than %d", Vertex1, Dist);
                  else PrintQueue (Queue, "Successor(s) -> ");
				  QueueDestroy (&Queue);
                  printf("\e[0m\e[35;1f| Press a key to continue ");
                  scanf ("%*[^\n]"); scanf ("%*c");
                  break;
		
        case 18 : ReadDigraphIndex (&Digraph1, "digraph");
                  if (NotActiveDigraph (DigraphArray, Digraph1)) break;
                  ReadVertex (&Vertex1);
                  Error = AllInEdgesVertex (DigraphArray[Digraph1], Vertex1, &Queue);
                  if (Error) { WriteErrorMessage (Error, "The determination of incident edges"); break; }
                  if (QueueIsEmpty (Queue)) printf("\e[1m\e[34;1f| Ther are no incident edges in vertex %d", Vertex1);
		          else PrintQueuePair (Queue, "Incident edge(s)");
				  QueueDestroy (&Queue);
				  printf("\e[0m\e[35;1f| Press a key to continue ");
                  scanf ("%*[^\n]"); scanf ("%*c");
                  break;
    }
  } while (Option != 0);

  for (Index = 0; Index < MAX_DIGRAPHS; Index++) 
    if (DigraphArray[Index] != NULL) Destroy (&DigraphArray[Index]);

  printf ("\e[37;1f");
  return 0;
}

void Menu (void)
{
  system ("clear");

  printf("\e[2;1f~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
  printf("\e[3;1f|                               Graphical Program for Simulate Operations with Digraphs/Graphs                             |\n");
  printf("\e[4;1f~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
  printf("\e[5;1f|  1 - Create an empty digraph   | Digraph  0 =                 |                                                          |\n");
  printf("\e[6;1f|  2 - Read digraph (from file)  | Digraph  1 =                 |                                                          |\n");
  printf("\e[7;1f|  3 - Insert a vertex           | Digraph  2 =                 |                                                          |\n");
  printf("\e[8;1f|  4 - Delete a vertex           | Digraph  3 =                 |                                                          |\n");
  printf("\e[9;1f|  5 - Insert an edge            | Digraph  4 =                 |                                                          |\n");
  printf("\e[10;1f|  6 - Delete an edge           | Digraph  5 =                 |                                                          |\n");
  printf("\e[11;1f|  7 - Store a digraph           | Digraph  6 =                 |                                                          |\n");
  printf("\e[12;1f|  8 - Copiar um digrafo         | Digraph  7 =                 |                                                          |\n");
  printf("\e[13;1f|  9 - Display a digraph         | Digraph  8 =                 |                                                          |\n");
  printf("\e[14;1f| 10 - Erase a digraph           | Digraph  9 =                 |                                                          |\n");
  printf("\e[15;1f| 11 - Type of vertex            | Digraph 10 =                 |                                                          |\n");
  printf("\e[16;1f| 12 - Classification of vertex  | Digraph 11 =                 |                                                          |\n");
  printf("\e[17;1f| 13 - Split edge                | Digraph 12 =                 |                                                          |\n");
  printf("\e[18;1f| 14 - Split vertex              | Digraph 13 =                 |                                                          |\n");
  printf("\e[19;1f| 15 - Transpose digraph         | Digraph 14 =                 |                                                          |\n");
  printf("\e[20;1f| 16 - Complement digraph        | Digraph 15 =                 |                                                          |\n");
  printf("\e[21;1f| 17 - Successors vertexes       | Digraph 16 =                 |                                                          |\n");
  printf("\e[22;1f| 18 - Incident edges            | Digraph 17 =                 |                                                          |\n");
  printf("\e[23;1f| 19 - xxxxxxxxxxxxxxxxxx        | Digraph 18 =                 |                                                          |\n");
  printf("\e[24;1f|  0 - Terminate program         | Digraph 19 =                 |                                                          |\n");
  printf("\e[25;1f|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~| Digraph 20 =                 |                                                          |\n");
  printf("\e[26;1f| Option ->                      | Digraph 21 =                 |                                                          |\n");
  printf("\e[27;1f~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
  printf("\e[28;1f|                                               Window for Data Acquisition                                                |\n");
  printf("\e[29;1f~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
  printf("\e[30;1f|                                                                                                                          |\n");
  printf("\e[31;1f~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
  printf("\e[32;1f|                                           Window for Error Messages and Results                                          |\n");
  printf("\e[33;1f~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
  printf("\e[34;1f|                                                                                                                          |\n");
  printf("\e[35;1f|                                                                                                                          |\n");
  printf("\e[36;1f~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
}

void ReadDigraphIndex (int *pndg, char *pmsg)
{
  int MsgLen = strlen (pmsg);

  do
  {
    *pndg = -1;
    printf("\e[30;1f| Index of %s ->                               ", pmsg);
    printf("\e[30;%df", 16+MsgLen); scanf ("%d", pndg);
    scanf ("%*[^\n]"); scanf ("%*c");
  } while (*pndg < 0 || *pndg >= MAX_DIGRAPHS);
}

int ActiveDigraph (PtDigraph pgrupodig[], int pndg)
{
  char Car;

  if (pgrupodig[pndg] != NULL)
  {
    do
    {
      printf("\e[1m\e[34;1f| The digraph %d already exists!                     ", pndg);
      printf("\e[0m\e[35;1f| Wish to erase it (y/n)? ");
      scanf ("%c", &Car); Car = tolower (Car);
      scanf ("%*[^\n]"); scanf ("%*c");
    } while (Car != 'y' && Car != 'n');

    if (Car == 'y') { Destroy (&pgrupodig[pndg]); return 0; }
    else  return 1;
  }
  else return 0;
}

int NotActiveDigraph (PtDigraph pgrupodig[], int pndg)
{
  if (pgrupodig[pndg] == NULL)
  {
    printf("\e[1m\e[34;1f| The digraph %d does not exist!                     ", pndg);
    printf("\e[0m\e[35;1f| Press a key to continue ");
    scanf ("%*[^\n]"); scanf ("%*c");
    return 1;
  }
  else return 0;
}

void ReadFilename (char *pnf)
{
  int Status;

  do
  {
    printf("\e[30;1f| Filename ->                               ");
    printf("\e[30;15f"); Status = scanf ("%20[^\n]", pnf);
    scanf ("%*[^\n]"); scanf ("%*c");
  } while (Status == 0);
}

void ReadOption (int *popc)
{
  do
  {  
    *popc = 0;
    printf("\e[26;1f| Option ->                       |");
    printf("\e[26;13f"); scanf ("%d", popc);
    scanf ("%*[^\n]"); scanf ("%*c");
  } while (*popc < 0 || *popc > MAX_OPTIONS);
}

void WriteErrorMessage (unsigned int perro, char *pmsg)
{
  printf("\e[34;1f| %s of digraphs was not executed because -> \e[1m", pmsg);
  switch (perro)
  {
    case NO_DIGRAPH    : printf ("Digraph does not exist"); break;
    case NO_MEM        : printf ("Out of memory"); break;
    case NULL_PTR      : printf ("Null pointer"); break;
    case DIGRAPH_EMPTY : printf ("Empty digraph"); break;
    case NO_VERTEX     : printf ("Vertex does not exist"); break;
    case REP_VERTEX    : printf ("Vertex already exists"); break;
    case NO_EDGE       : printf ("Edge does not exist"); break;
    case REP_EDGE      : printf ("Edge already exists"); break;
    case NO_FILE       : printf ("File does not exist"); break;
    case NO_DAG        : printf ("Acyclic digraph"); break;
    case NEG_CYCLE     : printf ("Digraph with negative cycle"); break;
    case NO_CONNECTED  : printf ("Graph disconnected"); break;
    case NO_PATH       : printf ("Path or circuit does not exist"); break;
	case SINK          : printf ("Sink vertex"); break;
	case SOURCE        : printf ("Source vertex"); break;
	case DISC          : printf ("Disconnected vertex"); break;
    default            : printf ("Unknown error");
  }
  printf("\e[0m\e[35;1f| Press a key to continue ");
  scanf ("%*[^\n]"); scanf ("%*c");
}

void ReadVertex (unsigned int *pvertex)
{
  do
  {
    printf("\e[30;1f| Vertex No ->                               ");
    printf("\e[30;16f"); scanf ("%d", pvertex);
    scanf ("%*[^\n]"); scanf ("%*c");
  } while (*pvertex <= 0);
}

void ReadEdge (unsigned int *pvert1, unsigned int *pvert2)
{
  do
  {
    printf("\e[30;1f| Origin vertex ->                               ");
    printf("\e[30;20f"); scanf ("%d", pvert1);
    scanf ("%*[^\n]"); scanf ("%*c");
  } while (*pvert1 <= 0);

  do
  {
    printf("\e[30;1f| Destination vertex ->                               ");
    printf("\e[30;25f"); scanf ("%d", pvert2);
    scanf ("%*[^\n]"); scanf ("%*c");
  } while (*pvert2 <= 0);
}

void ReadCostDist (int *pcost, char *pmsg)
{
  int Status;

  do
  {
    printf("\e[30;1f| %s ->                               ", pmsg);
    printf("\e[30;16f"); Status = scanf ("%d", pcost);
    scanf ("%*[^\n]"); scanf ("%*c");
  } while (Status != 1);
}

void ReadType (unsigned int *ptype)
{
  do
  {
    printf("\e[30;1f| Type Digraph (1) / Graph (0) ->                              ");
    printf("\e[30;35f"); scanf ("%d", ptype);
    scanf ("%*[^\n]"); scanf ("%*c");
  } while (*ptype > 1);
}

void WriteDigraph (PtDigraph pdigraph)
{
  unsigned int NVertexes, Index; char VertexList[256];

  VertexNumber (pdigraph, &NVertexes);

  printf("\e[1m");
  for (Index = 1; Index <= NVertexes; Index++)
  {
    GetVertexList (pdigraph, Index, VertexList);
    printf("\e[%d;66f ", 6+Index);
    printf ("%s\n", VertexList);
  }
  printf("\e[0m");
}

void PrintQueue (PtQueue pqueue, char *pmsg)
{
	if (pqueue == NULL) { printf ("Error\n"); return ; }
	
	int Number;

	printf("\e[1m\e[34;1f| %s ", pmsg);
	while (!QueueIsEmpty (pqueue))
	{
		QueueDequeue (pqueue, &Number);
		printf ("%d ", Number);
	}
}

void PrintQueuePair (PtQueue pqueue, char *pmsg)
{
	if (pqueue == NULL) { printf ("Error\n"); return ; }
	
	int Number, Line = 6, Count = 0;

	printf("\e[1m\e[5;66f %s", pmsg);
	printf ("\e[1m\e[%d;66f ", Line);
	while (!QueueIsEmpty (pqueue))
	{
		QueueDequeue (pqueue, &Number); printf ("(%d ", Number);
		QueueDequeue (pqueue, &Number); printf ("- %d) ", Number);
		Count++;
		if (Count % 7 == 0) { Line++; printf ("\e[1m\e[%d;66f ", Line); }
	}
}
