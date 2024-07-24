package views.admin;

import views.base.MostraProdBaseVIEW;

public class MostraProdAdminVIEW extends MostraProdBaseVIEW {
    @Override
    protected void voltar() {
        new OpcoesAdminVIEW();
        dispose();
    }

}
