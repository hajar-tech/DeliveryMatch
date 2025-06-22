import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListTrajetIdComponent } from './list-trajet-id.component';

describe('ListTrajetIdComponent', () => {
  let component: ListTrajetIdComponent;
  let fixture: ComponentFixture<ListTrajetIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListTrajetIdComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListTrajetIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
