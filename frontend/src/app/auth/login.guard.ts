import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { LoginService } from '../services/login.service';

export const loginGuard: CanActivateFn = (route, state) => {
  let loginService = inject(LoginService);

  if (loginService.hasPermission("COMUM") && state.url == '/admin/carros') {
    alert("Você não tem permissão de acesso a essa rota.");
    return false;
  }

  return true;
};
