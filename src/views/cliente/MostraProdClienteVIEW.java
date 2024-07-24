package views.cliente;

import views.base.MostraProdBaseVIEW;

public class MostraProdClienteVIEW extends MostraProdBaseVIEW {

    @Override
    protected void voltar() {
        new OpcoesClienteVIEW();
        dispose();
    }

}
