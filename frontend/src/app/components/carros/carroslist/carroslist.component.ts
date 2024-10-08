import { Carro } from './../../../models/carro';
import { Component, inject, TemplateRef, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import Swal from 'sweetalert2';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { CarroService } from '../../../services/carro.service';

@Component({
  selector: 'app-carroslist',
  standalone: true,
  imports: [CommonModule, RouterLink, MdbModalModule],
  templateUrl: './carroslist.component.html',
  styleUrl: './carroslist.component.scss'
})
export class CarroslistComponent {
  lista: Carro[] = [];

  carroService = inject(CarroService);

  constructor() {
    this.findAll();

    let carroNovo = history.state.carroNovo;
    let carroEditado = history.state.carroEditado;

    if (carroNovo) {
      carroNovo.id = 555;
      this.lista.push(carroNovo);
    }

    if (carroEditado) {
      let indice = this.lista.findIndex(x => { return x.id == carroEditado.id });
      this.lista[indice] = carroEditado;
    }
  }

  findAll() {
    this.carroService.findAll().subscribe({
      next: lista => {
        this.lista = lista;
      },
      error: erro => {
        alert("Ocorreu um erro.");
      },
    });
  }

  deletar(carro: Carro) {
    Swal.fire({
      title: 'Tem certeza que deseja deletar este registro?',
      icon: 'warning',
      showDenyButton: true,
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não'
    }).then((result) => {
      if (result.isConfirmed) {
        let indice = this.lista.findIndex(x => { return x.id == carro.id });
        this.lista.splice(indice, 1);

        Swal.fire({
          title: 'Deletado com sucesso!',
          icon: 'success',
          confirmButtonText: 'OK'
        });
      }
    });
  }
}
