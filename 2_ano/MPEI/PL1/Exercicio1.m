%% Codigo 1
% variaveis
p = 0.5;
k = 2;
n = 11;
sum_p = 0;
%funçaos

prob = factorial(n)/(factorial(n-k) * factorial(k))
    
%% Codigo 2
% Gerar uma matriz com 3 linhas e 10000 colunas de numeros aleatorios
% entre 0.0 e 1.0 (ou seja, cada coluna representa uma experiencia):
experiencias = rand(3,10000);
% Gerar uma matriz com 3 linhas e 10000 colunas com o valor 1 se o valor
% da matriz anterior for superior a 0.5 (ou seja, se saiu cara) ou com o
% valor 0 caso contr´ario (ou seja, saiu coroa):
lancamentos = experiencias > 0.5; % 0.5 corresponde a 1 - prob. de caras
% Gerar um vetor linha com 10000 elementos com a soma dos valores de cada
% coluna da matriz anterior (ou seja, o n´umero de caras de cada experiencia):
resultados= sum(lancamentos);
% Gerar um vetor linha com 10000 elementos com o valor 1 quando o valor do
% vetor anterior ´e 2 (ou seja, se a experiˆencia deu 2 caras) ou 0 quando ´e
% diferente de 2:
sucessos= resultados==2;
% Determinar o resultado final dividindo o n´umero de experiˆencias com 2
% caras pelo n´umero total de experiˆencias:
probSimulacao= sum(sucessos)/10000;

%% Codigo 2 - segunda vers˜ao
N= 1e5; %n´umero de experiˆencias
p = 0.5; %probabilidade de cara
k = 6; %n´umero de caras
n = 40; %n´umero de lanc¸amentos
lancamentos = rand(n,N) > p;
sucessos= sum(lancamentos)==k;
probSimulacao1 = sum(sucessos)/N

%% Codigo ex_5

pdef = 0.3; %probabilidade de defeito
n = 5;      %numero de amostras
k = 3;      %amostras com defeito

%analitico
%a
resultado_5a = factorial(n)/(factorial(n-k) * factorial(k)) * pdef^k * (1-pdef)^(n-k)
%b
sum_def = 0;
for i = 0:2
    sum_def = sum_def + factorial(n)/(factorial(n-i) * factorial(i)) * pdef^i * (1-pdef)^(n-i);
end

resultado_5b = sum_def




%simulacao

%a
N= 1e5; %numero de experiencias
experiencias = rand(n,N) < pdef;
sucessos= sum(experiencias)==k;
resultadoV2a = sum(sucessos)/N

%b
N= 1e5; %numero de experiencias
k = 2;
experiencias = rand(n,N) < pdef;
sucessos= sum(experiencias)<=k;
resultadoV2b = sum(sucessos)/N



%% Codigo ex_4
y = lancamento(0.5,20,1e5,6)

stem(y)
function f = lancamento(p,nlanc,nexp,ncaras)
    lancamentos = rand(nlanc,nexp) > p;
    sucessos= sum(lancamentos)==ncaras;
    f = sum(sucessos)/nexp;
    
end





