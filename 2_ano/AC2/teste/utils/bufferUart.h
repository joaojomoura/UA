#define BUF_SIZE 8 
#define INDEX_MASK (BUF_SIZE - 1)



typedef struct {
  unsigned char data [BUF_SIZE];
  unsigned int head;
  unsigned int tail;
  unsigned int count;
}circularBuffer;


