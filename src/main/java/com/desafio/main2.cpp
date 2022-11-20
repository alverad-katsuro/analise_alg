#include <iostream>
#include <string>
#include <sstream>
#include <assert.h>
#include <vector>

/* A Naive recursive implementation of
 0-1 Knapsack problem */
 
// A utility function that returns
// maximum of two integers
int max(int a, int b) { return (a > b) ? a : b; }
 
// Returns the maximum value that
// can be put in a knapsack of capacity W
void knapSack(int W, std::vector<int> wt, std::vector<int> val, int pacotes_total) {
  int i, w;
  std::vector<std::vector<int>> K(pacotes_total + 1, std::vector<int>(W + 1));
  int control1 = 0;
  int peso_max = 0;
  // Build table K[][] in bottom up manner
  for (i = 0; i <= pacotes_total; i++) {
      for (w = 0; w <= W; w++) {
          if (i == 0 || w == 0) {
              K[i][w] = 0;
          }
          else if (wt[i - 1] <= w) {
              K[i][w] = max(val[i - 1]+K[i - 1][w - wt[i - 1]], K[i - 1][w]);
          }
          else {
              K[i][w] = K[i - 1][w];
          }
          if (control1 < K[i][w]) {
            control1 = K[i][w];
            peso_max = w;
          }
      }
  }
  int ind = pacotes_total;
  int weight = W;
  int flag = 0;
  while (ind > 0) {
      if (K[ind][weight] != K[ind - 1][weight]) {
          flag++;
          weight -= wt[ind - 1];
      }
      ind -= 1;
  }
  std::cout << K[pacotes_total][W] << " brinquedos\n";
  std::cout << "Peso: " << peso_max << " kg\n";
  std::cout << "sobra(m) " << pacotes_total - flag  << " pacote(s)\n";
}

// std::cout << quantidade_b << " brinquedos\n";
// std::cout << "Peso: " << peso << " kg\n";
// std::cout << "sobra(m) " << resto_p << " pacote(s)\n";


int main() {
  int trigger = 0; // 0 n_viagens; 1 pacote n_viagem; 2 (for pacote) brinq - peso
  int limite = 50;
  int n_viagens;
  int pacote_n_viagem;
  int qt;
  int peso;
  std::string input;
  int aux;
  int empacotar = 0;

  std::vector<int> pesos;
  std::vector<int> brinquedos;

  while (std::getline(std::cin, input)) {
    if (trigger == 0) {
      std::stringstream st(input); // certeza que tem bug
      while (st >> aux) {
        n_viagens = aux; // if bug str int
      }
      trigger++;
    }
    else if (trigger == 1) {
      std::stringstream st(input); // certeza que tem bug
      while (st >> aux) {
        pacote_n_viagem = aux; // if bug str int
      }
      trigger++;
    }
    else if (trigger == 2) {
      if (pacote_n_viagem > empacotar) {
        std::stringstream st(input); // certeza que tem bug
        int i = -1;
        while (st >> aux) { // 2 times
          i++;
          if (i == 0)
          {
            if ((aux >= 1) && (aux <= 300))  {
              qt = aux;
              brinquedos.push_back(qt);
            }
          }
          else if (i == 1)
          {
            if ((aux >= 1) && (aux <= 50))
            {
              peso = aux;
              pesos.push_back(peso);
              empacotar += 1;
            }
          }
          if (pacote_n_viagem == empacotar) {
            knapSack(limite, pesos, brinquedos, pacote_n_viagem);
            std::cout << "\n";
            pacote_n_viagem = 0;
            empacotar = 0;
            trigger = 1;
            brinquedos.erase(brinquedos.begin(), brinquedos.end());
            pesos.erase(pesos.begin(), pesos.end());

            n_viagens--;
            if (n_viagens == 0) {
              return 0;
            }
          }
        }
      }
    }
  } 
}
