
package services;

import java.util.List;
import java.util.Scanner;

import entities.Pedido;
import enumeracoes.StatusPedido;
import excessoes.ExcessaoFormaPagamentoInvalida;
import excessoes.ExcessaoNumeroPagamentoInvalido;

public class EfetuarPagamento {

    public static List<Pedido> efetuarPagamento(List<Pedido> p)
            throws ExcessaoNumeroPagamentoInvalido, ExcessaoFormaPagamentoInvalida {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Qual pedido deseja pagar?: ");

        System.out.println("Pedidos existentes:");
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.get(i).getNumero());
        }

        int pedidoPagar = entrada.nextInt();
        entrada.nextLine();

        Pedido pedido = null;

        for (int i = 0; i < p.size(); i++) {

            if (pedidoPagar == p.get(i).getNumero()) {
                pedido = p.get(i);
                break;
            }
        }

        if (pedido == null) {
            throw new ExcessaoNumeroPagamentoInvalido(
                    "O número do pedido não existe!");
        }

        if (pedido.getStatus() == StatusPedido.PAGO) {
            System.out.println("Este pedido já foi pago!");
            return p;
        }

        if (pedido.getItens() == null || pedido.getItens().isEmpty()) {
            System.out.println("Não é possível pagar um pedido sem produtos!");
            return p;
        }

        double total = 0.0;

        for (int i = 0; i < pedido.getItens().size(); i++) {

            total += pedido.getItens().get(i).getProduto().getPreco()
                    * pedido.getItens().get(i).getQuantidade();
        }

        System.out.println("Como deseja pagar?: ");
        System.out.println("1 - PIX");
        System.out.println("2 - CARTÃO (TAXA DE 3%)");

        int dec = entrada.nextInt();
        entrada.nextLine();

        if (dec != 1 && dec != 2) {
            throw new ExcessaoFormaPagamentoInvalida(
                    "Forma de pagamento inválida!");
        }

        boolean controle = true;

        if (dec == 1) {

            while (controle) {

                System.out.printf("Total a pagar: R$ %.2f%n", total);
                System.out.println("Digite o valor e confirme:");

                double pagamento = entrada.nextDouble();
                entrada.nextLine();

                long valorInformado = Math.round(pagamento * 100);
                long valorEsperado = Math.round(total * 100);

                if (valorInformado == valorEsperado) {

                    System.out.println("Pagamento realizado com sucesso!");

                    pedido.setStatus(StatusPedido.PAGO);
                    controle = false;

                } else {
                    System.out.println("Valor incorreto! Tente novamente...");
                }
            }

        } else if (dec == 2) {

            total = Math.round(total * 1.03 * 100) / 100.0;

            while (controle) {

                System.out.printf("Total a pagar: R$ %.2f%n", total);

                System.out.println("Digite o número do cartão (6 DÍGITOS):");
                String numeroCartao = entrada.nextLine();

                if (!numeroCartao.matches("\\d{6}")) {
                    System.out.println(
                            "Número do cartão inválido! Digite exatamente 6 números.");
                    continue;
                }

                System.out.println("Digite a senha do cartão (4 DÍGITOS):");
                String senhaCartao = entrada.nextLine();

                if (!senhaCartao.matches("\\d{4}")) {
                    System.out.println(
                            "Senha inválida! Digite exatamente 4 números.");
                    continue;
                }

                System.out.println("Pagamento realizado com sucesso!");

                pedido.setStatus(StatusPedido.PAGO);
                controle = false;
            }
        }

        return p;
    }
}
