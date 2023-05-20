import sys

N = int(sys.stdin.readline())
N_list = list(map(int,sys.stdin.readline().split()))

# 이진 탐색을 위한 sort
N_list.sort()

p1 = 0
p2 = len(N_list)-1

# 모두 산성 용액으로 이뤄졌을 경우 
if N_list[0]>=0 and N_list[1]>=0:
    print(N_list[0],N_list[1])
# 모두 알칼리성 용액만으로 이뤄졌을 경우 
elif N_list[-1]<=0 and N_list[-2]<=0:
    print(N_list[-2],N_list[-1])
    
else:
    # 가장 큰 수 넣어주면서 초기화 
    result = [N_list[p1],N_list[p2],abs(N_list[p1]+N_list[p2])]

    while p1<p2:
        # 만약 포인터의 합이 더 작으면 result 바꿔줌
        sum = N_list[p1] + N_list[p2]
        if abs(sum) < result[2]:
            result[0] = N_list[p1]
            result[1] = N_list[p2]
            result[2] = abs(sum)
            if sum==0:
                break
            
        if sum<0:
            p1+=1
        else:
            p2-=1
        
    print(result[0],result[1])
