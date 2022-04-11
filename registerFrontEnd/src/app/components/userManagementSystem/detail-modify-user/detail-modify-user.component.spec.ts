import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailModifyUserComponent } from './detail-modify-user.component';

describe('DetailModifyUserComponent', () => {
  let component: DetailModifyUserComponent;
  let fixture: ComponentFixture<DetailModifyUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailModifyUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailModifyUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
