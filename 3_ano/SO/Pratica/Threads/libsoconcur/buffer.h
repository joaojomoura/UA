typedef struct {
  char msg[1024];
} ServiceRequest;

typedef struct {
  int count;
  int countAlpha;
  int countDigit;
} ServiceResponse;

typedef struct {
  ServiceRequest req;
  ServiceResponse res;
} Buffer;
