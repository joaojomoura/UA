%% codigo 5

p = 0.5;
k = 2;
n = 3;

prob = nchoosek(n,k) * p^k * (1-p)^(n-k) 

%% codigo 6

pdef = 0.3; %probabilidade de ser defeito
n = 5;      % numero de amostras
k = 2;      %numero de amostras defeituosas

prob1 = lancamento(pdef,n,k,1e5)

prob2 = nchoosek(n,k) * p^k * (1-p)^(n-k) %analitico
hist(prob1)
%% funcoes
function f = nchoosek(n,k)
    f = factorial(n)/factorial(n-k)/factorial(k);
end

function f1 = lancamento(p, nlanc, ncara, nexp)
    lancamentos = rand(nlanc,nexp) > p;
    sucessos = sum (lancamentos) == ncara;
    f1 = sum(sucessos)/nexp;
end