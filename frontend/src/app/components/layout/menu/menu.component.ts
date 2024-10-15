import { Component, inject } from '@angular/core';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { LoginService } from '../../../services/login.service';
import { Usuario } from '../../../models/usuario';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [MdbCollapseModule],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})

export class MenuComponent {
  usuario!: Usuario;

  loginService = inject(LoginService);

  constructor() {
    this.usuario = this.loginService.getUsuarioLogado();
  }
}
