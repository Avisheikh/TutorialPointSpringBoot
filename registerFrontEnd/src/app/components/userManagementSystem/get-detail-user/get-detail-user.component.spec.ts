import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetDetailUserComponent } from './get-detail-user.component';

describe('GetDetailUserComponent', () => {
  let component: GetDetailUserComponent;
  let fixture: ComponentFixture<GetDetailUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetDetailUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetDetailUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
