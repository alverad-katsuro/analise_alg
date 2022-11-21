def remove_min(vec, index):
  vec.pop(index) #, 1)

def eaw(N, D, vec):
  begin = -1
  end = 0
  while (len(vec) != (N - D)):
   # 759, 3
    begin+=1;
    end+=1;
    if (vec[begin] < vec[end]):
      remove_min(vec, begin)
      if (begin >= 1):
        begin -= 2
        end -= 2
      else:
        begin -= 1
        end -= 1
      continue
    else:
      if (end == (len(vec) - 1)):
        remove_min(vec, end)
        begin -= 2
        end -= 2
        continue
    
def main():
    trigger = 0
    N = -1
    D = -2
    while True:
        entrada = input() 
        if (entrada == "0 0"):
          exit(0)
        else:
            if (trigger == 0):
                split = entrada.split();
                split = list(map(int, split))
                for i in range(0, 2):
                    if (i == 0):
                        if ((split[i] > 1) and (split[i] <= 100000)):
                            N = split[i]
                    elif (i == 1):
                        if ((split[i] >= 1) and (split[i] < N)):
                            D = split[i]
                trigger+=1
            elif (trigger == 1):
                word = list(entrada)
                eaw(N, D, word)       
                print("{}\n".format(''.join(word)))
                trigger-=1
                
main()
