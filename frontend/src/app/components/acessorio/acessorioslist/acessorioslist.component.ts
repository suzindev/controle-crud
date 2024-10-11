import { Component, EventEmitter, inject, Input, Output, TemplateRef, ViewChild } from '@angular/core';
import { Acessorio } from '../../../models/acessorio';
import { MdbModalModule, MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { AcessorioService } from '../../../services/acessorio.service';
import Swal from 'sweetalert2';
import { RouterLink } from '@angular/router';
import { AcessoriosdetailsComponent } from '../acessoriosdetails/acessoriosdetails.component';

@Component({
  selector: 'app-acessorioslist',
  standalone: true,
  imports: [RouterLink, MdbModalModule, AcessoriosdetailsComponent],
  templateUrl: './acessorioslist.component.html',
  styleUrl: './acessorioslist.component.scss'
})
export class AcessorioslistComponent {
  lista: Acessorio[] = [];
  acessorioEdit: Acessorio = new Acessorio();

  @Input("enableButton") enableButton: boolean = false;
  @Output("retorno") retorno = new EventEmitter<any>();

  modalService = inject(MdbModalService);
  @ViewChild('modalAcessorioDetalhe') modalAcessorioDetalhe!: TemplateRef<any>;
  modalRef!: MdbModalRef<any>;

  acessorioService = inject(AcessorioService);

  constructor() {
    this.findAll();
  }

  findAll() {
    this.acessorioService.findAll().subscribe({
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

  deletar(acessorio: Acessorio) {
    Swal.fire({
      title: 'Tem certeza que deseja deletar este registro?',
      icon: 'warning',
      showDenyButton: true,
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não'
    }).then((result) => {
      if (result.isConfirmed) {
        this.acessorioService.delete(acessorio.id).subscribe({
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
    this.acessorioEdit = new Acessorio();
    this.modalRef = this.modalService.open(this.modalAcessorioDetalhe)
  }

  edit(acessorio: Acessorio) {
    this.acessorioEdit = Object.assign({}, acessorio);
    this.modalRef = this.modalService.open(this.modalAcessorioDetalhe)
  }

  select(acessorio: Acessorio) {
    this.retorno.emit(acessorio);
  }

  retornoAcessorioDetalhe() {
    this.findAll();
    this.modalRef.close();
  }
}
