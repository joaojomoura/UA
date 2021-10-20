p = 0.7;
k = 2;
n = 5;
prob = nchoosek(n,k)*p^k*(1-p)^(n-k) % nchoosek(n,k)= n!/(n-k)!/k!

%% c) histograma do número de peças defeituosas
n = 5;
k = 2;
p = 0.3;
N = 1e5;
experiencias = rand(n, N)>0.7;
sucessos = sum(experiencias)<=2;
prob = sum(sucessos)/N;
hist(sucessos)
