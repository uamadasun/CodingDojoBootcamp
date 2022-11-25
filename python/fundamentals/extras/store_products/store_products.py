class Store:
    def __init__(self, name, product_list=[]):
        self.name = name
        self.product_list = product_list

    def add_product(self, new_product):
        new_product = Product(new_product.name, new_product.price, new_product.category)
        self.product_list.append(new_product)
        return


class Product:
    def __init__(self, name, price, category):
        self.name = name
        self.price = price
        self.category = category

    def update_price(self,percent_change,is_increased):
        if is_increased:
            self.price = self.price * (1 + percent_change)
        else:
            self.price = self.price * (1-percent_change)
        return
    
    def print_info(self):
        updated_price = "${:,.2f}".format(self.price)
        print(f"Name of Product: {self.name}\nCategory: {self.category}\nPrice:{updated_price} ")
        return

new_product = Product("New Product", 1, "Automotive")

new_product.print_info()
new_store = Store("new store")

new_store.add_product(new_product)
print(new_store.product_list)