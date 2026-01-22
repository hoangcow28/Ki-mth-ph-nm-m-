describe('Cart and Checkout Test', () => {
    beforeEach(() => {
        // Đăng nhập trước khi thực hiện các thao tác khác
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
    });

    it('Kịch bản 3: Thêm sản phẩm vào giỏ hàng', () => {
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        cy.get('.shopping_cart_badge').should('have.text', '1');
    });

    it('Kịch bản 4: Lọc sản phẩm theo giá (Thấp đến Cao)', () => {
        cy.get('.product_sort_container').select('lohi');
        cy.get('.inventory_item_price').first().should('have.text', '$7.99');
    });


    it('Kịch bản 5: Xóa sản phẩm khỏi giỏ hàng', () => {
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        cy.get('.shopping_cart_badge').should('have.text', '1');

        cy.get('.inventory_item').first().find('.btn_inventory').click();

        cy.get('.shopping_cart_badge').should('not.exist');
    });

    it('Kịch bản 6: Kiểm tra quy trình thanh toán (Checkout)', () => {
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        cy.get('.shopping_cart_link').click();
        cy.get('#checkout').click();
        cy.get('#first-name').type('John');
        cy.get('#last-name').type('Doe');
        cy.get('#postal-code').type('12345');
        cy.get('#continue').click();
        cy.url().should('include', '/checkout-step-two.html');
        cy.get('.title').should('contain', 'Checkout: Overview');
    });
});