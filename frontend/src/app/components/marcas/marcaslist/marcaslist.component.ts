import { CommonModule } from '@angular/common';
import { Component, inject, TemplateRef, ViewChild } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MdbModalModule, MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { Marca } from '../../../models/marca';
import { MarcaService } from '../../../services/marca.service';
import Swal from 'sweetalert2';
import { MarcasdetailsComponent } from '../marcasdetails/marcasdetails.component';

@Component({
  selector: 'app-marcaslist',
  standalone: true,
  imports: [CommonModule, RouterLink, MdbModalModule, MarcasdetailsComponent],
  templateUrl: './marcaslist.component.html',
  styleUrl: './marcaslist.component.scss'
})
export class MarcaslistComponent {
  lista: Marca[] = [];
  marcaEdit: Marca = new Marca();

  modalService = inject(MdbModalService);
  @ViewChild('modalMarcaDetalhe') modalMarcaDetalhe!: TemplateRef<any>;
  modalRef!: MdbModalRef<any>;

  marcaService = inject(MarcaService);

  constructor() {
    this.findAll();
  }

  findAll() {
    this.marcaService.findAll().subscribe({
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

  deletar(marca: Marca) {
    Swal.fire({
      title: 'Tem certeza que deseja deletar este registro?',
      icon: 'warning',
      showDenyButton: true,
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não'
    }).then((result) => {
      if (result.isConfirmed) {
        this.marcaService.delete(marca.id).subscribe({
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

  new() {
    this.marcaEdit = new Marca();
    this.modalRef = this.modalService.open(this.modalMarcaDetalhe)
  }

  edit(marca: Marca) {
    this.marcaEdit = Object.assign({}, marca);
    this.modalRef = this.modalService.open(this.modalMarcaDetalhe)
  }

  retornoMarcaDetalhe() {
    this.findAll();
    this.modalRef.close();
  }
}
