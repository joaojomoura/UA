%% Codigo 1
% Gerar uma matriz com 3 linhas e 10000 colunas de nu´meros aleato´rios
% entre 0.0 e 1.0 (ou seja, cada coluna representa uma experieˆncia):
experiencias = rand(3,10000);
% Gerar uma matriz com 3 linhas e 10000 colunas com o valor 1 se o valor
% da matriz anterior for superior a 0.5 (ou seja, se saiu cara) ou com o
% valor 0 caso contra´rio (ou seja, saiu coroa):
lancamentos = experiencias > 0.5; % 0.5 corresponde a 1 - prob. de caras
% Gerar um vetor linha com 10000 elementos com a soma dos valores de cada
% coluna da matriz anterior (ou seja, o nu´mero de caras de cada experieˆncia):
resultados= sum(lancamentos);
% Gerar um vetor linha com 10000 elementos com o valor 1 quando o valor do
% vetor anterior e´ 2 (ou seja, se a experieˆncia deu 2 caras) ou 0 quando e´
% diferente de 2:
sucessos= resultados==2;
% Determinar o resultado final dividindo o nu´mero de experieˆncias com 2
% caras pelo nu´mero total de experieˆncias:
probSimulacao1 = sum(sucessos)/10000

%% Codigo 1 - segunda versa˜o
N= 1e5; %nu´mero de experieˆncias
p = 0.5; %probabilidade de cara
k = 2; %nu´mero de caras
n = 3; %nu´mero de lanc¸amentos
lancamentos = rand(n,N) > p;
sucessos= sum(lancamentos)==k;
probSimulacao1 = sum(sucessos)/N

%% codigo 2
N = 1e5;    %numero de experiencias
p = 0.5;    %probabilidade de sair cara
k = 6;      %numero de caras
n = 15;     %numero de lançamentos

lancamentos = rand(n,N) > p;
sucessos= sum(lancamentos)==k;
probSimulacao2 = sum(sucessos)/N

%% codigo 3
N = 1e5;    %numero de experiencias
p = 0.5;    %probabilidade de sair cara
k = 6;      %numero de caras
n = 15;     %numero de lançamentos

lancamentos = rand(n,N) > p;
sucessos= sum(lancamentos)<=k;
probSimulacao3 = sum(sucessos)/N

%% codigo 4
y1 = lancamento(0.5,20,3,1e5)
stem(y1)

function f = lancamento(p, nlanc, ncara, nexp)
    lancamentos = rand(nlanc,nexp) > p;
    sucessos = sum (lancamentos) == ncara;
    f = sum(sucessos)/nexp;
end




