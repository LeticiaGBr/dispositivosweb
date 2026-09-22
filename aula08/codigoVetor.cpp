#include <iostream>
using namespace std;

bool inserir(int numero, int v[],int i){
    if(i<5){ 
    v[i] = numero;
     return true;
    }else{
        return false;
    }
}
bool remover(int v[],int i){
    v[i] = 0;
    return true;

}
int main(){
    int vetor[5],quantidade = 0, escolha =1,numero,i=0;
    bool resposta;

    while (numero != -1){
        cout << "Digite o " << i+1 <<" valor: ";
        cin >> numero;
        resposta = inserir(numero,vetor,i);
        if (resposta == true){
            cout <<"Numero Inserido" <<endl;
            i++;
        }else {
            cout <<"Não é possivel inserir mais saia do while digitando -1" <<endl;
        }
    }
     
    for (int j = 0; j < 5; j++){
        if (vetor[j] != 0){
            quantidade = quantidade +1;
        } else{
            quantidade = quantidade;
        }
    }

    for (int i = 0; i<5;i++){
        cout <<"Posicao " << i+1 << " Valor: " << vetor[i] << endl; 
    }
    cout << "Quantidade de posicoes preenchidas: "<< quantidade <<" de 5" << endl;
    while(escolha != 0){
        cout <<"Escolha uma posicao para procurar entre numeros de 1 a 5: " <<endl <<"Digite 0 para sair" << endl <<"Digite 6 para remover : ";
        cin >> escolha;
        if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4 || escolha == 5) {
        cout << "valor: " << vetor[escolha -1] << " Posicao: " << escolha <<endl;
        }else if(escolha == 6){
            cout << "Digite qual posicao remover: "<< endl;
            cin >> i;
            resposta = remover(vetor,i-1);
            if (resposta == true){
                cout << "Numero removido novos registros." << endl;
                for (int i = 0; i<5;i++){
                   cout <<"Posicao " << i+1 << " Valor: " << vetor[i] << endl; 
                }
            }
        }

    }

    return 0;
}