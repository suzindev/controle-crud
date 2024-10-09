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
  }

  findAll() {
    this.carroService.findAll().subscribe({
      next: lista => {
        this.lista = lista;
      },
      error: erro => {
        Swal.fire({
          title: 'Ocorreu um erro',
          icon: 'error',
          confirmButtonText: 'OK'
        });
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
        this.carroService.delete(carro.id).subscribe({
          next: mensagem => {
            Swal.fire({
              title: mensagem,
              icon: 'success',
              confirmButtonText: 'OK'
            });

            this.findAll();
          },
          error: erro => {
            Swal.fire({
              title: 'Ocorreu um erro',
              icon: 'error',
              confirmButtonText: 'OK'
            });
          }
        });
      }
    });
  }
}
