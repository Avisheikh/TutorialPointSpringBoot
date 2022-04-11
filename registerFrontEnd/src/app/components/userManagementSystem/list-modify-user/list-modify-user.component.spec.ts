import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListModifyUserComponent } from './list-modify-user.component';

describe('ListModifyUserComponent', () => {
  let component: ListModifyUserComponent;
  let fixture: ComponentFixture<ListModifyUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListModifyUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListModifyUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
